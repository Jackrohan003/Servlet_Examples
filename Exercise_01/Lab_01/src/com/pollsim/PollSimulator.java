package com.pollsim;
import java.util.Random;

public class PollSimulator {
	public static void main(String[] args) {

		String[] candNames = new String[5];
		candNames[0] = "Deep Goyal";
		candNames[1] = "Sneha Mohan";
		candNames[2] = "Praveen Shah";
		candNames[3] = "Akshay Singh";
		candNames[4] = "Somin Majumdar";
		
		PollBO poll = new PollBO(candNames);
		int nc = poll.getNumberOfCandidates();
		Random rand = new Random(55);
		for (int i = 1; i <= 10; i++) {
			// generate random number between 0 to nc-1
			int x =  rand.nextInt(nc);
			// vote to x
			poll.voteTo(x);
			System.out.print(x+" ");
			// this increments vote count for candidate x by 1
			// the method does need to record who votes to whom
		} // Assume that candidates are identified as 1 through 5
			// Report the election result
		for (int i = 0; i <poll.getNumberOfCandidates(); i++) {
			System.out.println(poll.getCandidateName(i) + ": " + poll.votesCount(i));
		}
		System.out.println("Winner: " + poll.getWinner());
	}
}