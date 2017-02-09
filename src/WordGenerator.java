import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {
	private Scanner openFile;
	private int wordCounter, sentenceCounter;

	public WordGenerator(String filename) throws IOException {
		openFile = new Scanner(new File(filename));
	}

	public boolean hasNext() {
		return openFile.hasNext();
	}
	/* 
	 * @return Returns the next word of the WordGenerator.
	 */
	public String next() {
		String nextWord = openFile.next();
		if (nextWord.contains(".") || nextWord.contains("?") || nextWord.contains("!"))
			sentenceCounter++;
		wordCounter++;
		//System.out.println(wordCounter);
		return nextWord;
	}

	/*
	 * @return Returns the number of words produced by the current WordGenerator so far.
	 */
	int getWordCount() {
		return wordCounter;
	}

	/*
	 * Returns the total number of sentences produced by the current WordGenerator so far.
	 */
	int getSentenceCount() {
		return sentenceCounter;
	}
}
