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
	
	public String next() {
		String nextWord = openFile.next();
		if (nextWord.contains(".") || nextWord.contains("?") || nextWord.contains("!"))
			sentenceCounter++;
		wordCounter++;
		return nextWord;
	}
	
	int getWordCount() {
		return wordCounter;
	}
	
	int getSentenceCount() {
		return sentenceCounter;
	}
}
