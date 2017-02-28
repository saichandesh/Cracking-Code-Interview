package com.crackingcode.stacksandqueues;

import java.util.EmptyStackException;

class StackElement{
	int data;
	StackElement next;
	int mindata;
	
	StackElement(int data){
		this.data = data;
		next = null;
	}
}

public class StackMin {
	
	StackElement top;
	
	public void push(int data){
		
		StackElement se = new StackElement(data);
		
		if(top == null){
			top = se;
			top.mindata  = data;
		}else{
			if(top.data > data){
				se.next = top;
				se.mindata = top.data;
				top = se;
			}else{
				if(top.next==null){
					top.next = se;
					se.mindata = data;
				}else{
					se.next = top.next;
					if(data > top.mindata){
						if(data > top.next.mindata){
							se.mindata = top.next.mindata;
							
						}else{
							se.mindata = top.next.data;
							top.next.mindata = data;
						}
					}else{
						se.mindata = top.mindata;
						top.mindata = data;
					}
					top.next = se;
				}
			}
		}
		
	}
	
	public int min(){
		int value;
		if(top == null) throw new EmptyStackException();
		if(top.data<= top.mindata)
			value = top.data;
		else
			value = top.mindata;
		return value;
	}
	
	public int pop(){
		int value = 0;
		if(top == null) throw new EmptyStackException();
		value = top.data;
		if(top.data > top.mindata){
			top.next.mindata = top.mindata;
		}
		if(top.next != null)
			top = top.next;
		return value;
	}
	
	public static void main(String[] args){
		StackMin sm = new StackMin();
		sm.push(10);
		System.out.println(sm.min());//10
		sm.push(13);
		System.out.println(sm.min());//10
		sm.push(9);
		System.out.println(sm.min());//9
		sm.push(50);
		System.out.println(sm.min());//9
		sm.pop();
		System.out.println(sm.min());//10
		sm.pop();
		System.out.println(sm.min());//10
		sm.pop();
		System.out.println(sm.min());//13
	}
}
