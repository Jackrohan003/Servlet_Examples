package com.pollsim;

import java.util.HashMap;

public class PollBO {

	String name[];
	HashMap<Integer,Integer>map = new HashMap<>();
	
	PollBO(String n[]){
		name=new String[n.length];
		name = n;
	}
	
	public int getNumberOfCandidates()
	{
		return name.length;
	}
	public void voteTo(int x) {
	
		if(map.containsKey(x)) {
			map.put(x,map.get(x)+1);
		}
		else
			map.put(x,1);
	}
	public int votesCount(int i) {
		return map.get(i);
	}
	public String getWinner() {
		String s="";
		int max=0;
		int index=0;
		
		for(Integer x: map.keySet()) {
			int vote=map.get(x);
			if(max<vote) {
				max =vote;
				index = x;
			}
		}	
		s=name[index];
		return s;
	}
	public String getCandidateName(int i)
	{
		return name[i];
	}
}
