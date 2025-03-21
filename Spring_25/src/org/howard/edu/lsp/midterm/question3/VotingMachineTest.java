package org.howard.edu.lsp.midterm.question3;

/**
 * Test class for VotingMachine implementation
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Brent");
        vm.addCandidate("Bernard");
        vm.addCandidate("Biden");

        // Casting votes
        vm.castVote("Brent");
        vm.castVote("Brent");
        vm.castVote("Biden");
        vm.castVote("Bernard");
        vm.castVote("Bernard");
        vm.castVote("Bernard");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Woolfolk");
        System.out.println("Vote for Woolfolk successful? " + success);

        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
} 
