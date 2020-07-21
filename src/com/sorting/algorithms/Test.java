package com.sorting.algorithms;

public class Test {

	// Sentence - Length of line, arrange words in sentence, optimal number of lines
	
	public static void main(String[] args) {
		
		String sentence = "This is a test string which I am writing";//args[0];
		int length = sentence.length();//Integer.parseInt(args[1]);
		char []array = sentence.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 10,start=0 ; start< length ; i=start+10) {
			if (i>length)
				i=length;
			if (array[i]==' ') {
				if(i<length)
				{
					sb.append(sentence.substring(start,i));
					start=i;
				}
				else
				{
					sb.append(sentence.substring(start,length));
				}
				sb.append("\n");
			}
			else {
				int j;
				for(j=i;array[j]!=' '; j--) {
				}
				sb.append(sentence.substring(start,j));
				sb.append("\n");
				start=j+1;
			}
		}
	System.out.println(sb);
	}
}
