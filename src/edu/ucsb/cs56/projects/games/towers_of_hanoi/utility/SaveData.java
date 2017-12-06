package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.io.*;
import java.awt.*;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

public class SaveData implements Serializable {
    private static final long serialVersionUID = 1L;
    public HanoiTimer timer;
    public TowersOfHanoiState state; 
}
