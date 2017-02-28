package com.crackingcode.stacksandqueues;

import java.util.EmptyStackException;

public class ThreeInOne<T> {
	
	T[] a = (T[]) new Object[100];
	
	
	static int firstStack = -1;
	static int secondStack = -1;
	static int thirdStack = -1;
	
	public void push(T data,int stackNumber){
		switch(stackNumber){
		case 1 : if(firstStack == ((a.length/3)-1)) throw new StackOverflowError();
				firstStack++;
				a[firstStack] = data;
				
			break;
		case 2 : if(secondStack == (((a.length/3)*2)-1)) throw new StackOverflowError();
				secondStack++;
				a[secondStack] = data;
				
			break;
		case 3 : if(thirdStack == (a.length-1)) throw new StackOverflowError();
				thirdStack++;
				a[thirdStack] = data;
				
			break;
		}
	}
	
	public boolean isEmpty(int stackNumber){
		boolean isempty = false;
		switch(stackNumber){
			case 1 : if(firstStack == -1){
						isempty	= true;
			}else{
					isempty  = false;
			}
					break;
			case 2 :
				if(secondStack == (a.length/3)-1){
					isempty	= true;
				}else{
					isempty  = false;
				}
				break;
				
			case 3 : 
				if(thirdStack == ((a.length/3) * 2 )-1){
					isempty	= true;
				}else{
					isempty  = false;
				}
				break;
				
		}
		return isempty;
	}
	
	public T pop(int stackNumber){
		T data = null;
		switch(stackNumber){
			case 1 : if(firstStack == -1) throw new EmptyStackException();
				data = a[firstStack];
				firstStack--;
				break;
			case 2 : if(secondStack == (a.length/3)-1) throw new EmptyStackException();
				data = a[secondStack];
				secondStack--;
				break;
			case 3 : if(thirdStack == ((a.length/3)*2)-1) throw new EmptyStackException();
				data = a[thirdStack];
				thirdStack--;
				break;
		}
		return data;
	}
	
	public T peek(int stackNumber){
		T data = null;
		
		switch(stackNumber){
			case 1 : if(firstStack == 0) throw new EmptyStackException();
				data = a[firstStack];
				break;
			case 2 : if(secondStack == a.length/3) throw new EmptyStackException();
				data = a[secondStack];
				break;
			case 3 : if(thirdStack == ((a.length/3)*2)) throw new EmptyStackException(); 
				data = a[thirdStack];
				break;
		}
		
		return data;
	}
	
	public static void main(String[] args){
		
		ThreeInOne tio = new ThreeInOne();
		
		secondStack = (tio.a.length/3) -1 ;
		thirdStack = ((tio.a.length/3)*2)-1;
		
		tio.push(10, 1);
		System.out.println(tio.isEmpty(1));
		tio.push(10, 2);
		System.out.println(tio.isEmpty(2));
		tio.push(10, 3);
		System.out.println(tio.isEmpty(3));
		tio.pop(1);
		System.out.println(tio.isEmpty(1));
		
	}
	
	
}
