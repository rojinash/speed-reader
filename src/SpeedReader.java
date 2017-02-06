import java.awt.*;

public class SpeedReader {

	public static void main(String[] args) {
		String usage = "Usage: SpeedReader <filename> <width> <height> <font size> <wpm>";
		if (args.length != 5) {
			System.out.print(usage);
			System.exit(1);
		}
		
		String filename = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontsize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);

		WordGenerator wordgen = new WordGenerator(filename);

		DrawingPanel panel = new DrawingPanel(width, height);
	    Graphics g = panel.getGraphics();
	    Font f = new Font("Courier", Font.BOLD, fontsize);
	    g.setFont(f);
	    while (wordgen.hasNext()) {
	    	try {
	    g.drawString(wordgen.next(), 100, 100);
	    Thread.sleep(calculateDelay(wpm));
	    panel.clear();
	    } catch (InterruptedException ex) {
	    	
	    }
	    }
	    System.out.println("Total words displayed: " + wordgen.getWordCount());
	    System.out.println("Total sentences displayed: " + wordgen.getSentenceCount());
		}

	/*
	 * @param Words per minute
	 * @return Delay (in milliseconds) required between the display of words
	 */
	public static long calculateDelay(int wpm){
		int delay =  (60000 / wpm);
		return delay;
	}
}
