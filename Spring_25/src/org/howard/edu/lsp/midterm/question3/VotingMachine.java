package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a simple electronic voting machine
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    /**
     * Constructor initializes an empty voting machine
     */
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a new candidate to the voting machine
     */
    public void addCandidate(String name) {
        votes.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for the specified candidate
     * @return true if vote was successful, false if candidate doesn't exist
     */
    public boolean castVote(String name) {
        if (!votes.containsKey(name)) {
            return false;
        }
        votes.put(name, votes.get(name) + 1);
        return true;
    }

    /**
     * Returns the winner of the election
     * @return String representing the winner and their vote count
     */
    public String getWinner() {
        if (votes.isEmpty()) {
            return "No votes cast";
        }

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
} 