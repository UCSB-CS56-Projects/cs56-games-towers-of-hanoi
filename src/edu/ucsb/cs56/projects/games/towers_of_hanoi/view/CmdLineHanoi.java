edu.ucsb.cs56.projects.games.towers_of_hanoi.view;



public class CmdLineHanoi{





    public static void main(String [] args){

	int disks;

	if (args.length == 0){

	    System.out.println("Proper Usage: CmdLineHanoi is a command line interface that takes in
                                an integer (Number of disks) for a Towers of Hanoi game.");
	    System.exit(0);
	}

	else if (args.length > 0) {
	    try {
		disks = Integer.parseInt(args[0]);
	    } catch (NumberFormatException e) {
		System.err.println("Argument" + " must be an integer");
		System.exit(1);
	    }
	}

    


    

    }





}
