package file_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	List<String> data = new ArrayList<>();
	File f;
	PrintWriter outputStream = null;

	public FileHandler(List<String> data) {
		this.data = data;
		f = new File("C://xampp/htdocs/data.tsv");
	}

	/**
	 * Auth h methodos kanei create data.tsv arxeio gia na to diabasei to d3.js
	 * @param from: apo poio etos kai meta na ginei h grafikh parastash
	 * @param to: mexri poio etos na ginei h grafikh parastash
	 * @param range: and 1, 5, 10 eti ta dedomena
	 */
	public void createTSVFile(int from, int to, int range) {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outputStream = new PrintWriter(new FileOutputStream(f)); // output
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
		}

		int first = 0;
		for (String s: data) {
			String[] parts = s.split("\\s+");
			for (int i = 0; i < parts.length; i++) {
				if (first == 0) {
					String toPut = "SeriesName\tCountryName\t";
					for (int j = from; j <= to; j += range) {
						if (j == to) {
							toPut += j +"";
						} else {
							toPut += j + "\t";
						}
					}
					outputStream.println(toPut);
					first = 1;
				}
				int pos = 0;
				for (String word: parts) {
					try {
					    Double.parseDouble(word);
					    break; // bges apo thn epanalhpsh auto me endiaferei
					} catch (NumberFormatException e) { // ama den einai arithmos
						pos++;
						// do nothing
					}
				}
				for (int k = 0; k < pos; k++) {
					if (k == pos-1) {
						outputStream.print("\t" + parts[k] + "\t");
					} else {
						String put = parts[k] + " ";
						put = put.trim();
						outputStream.print(put + " ");
					}
				}
				for (i = pos; i < parts.length; i++) {
					if (i == parts.length-1) {
						outputStream.print(parts[parts.length-1]); // copy to file
					} else {
						outputStream.print(parts[i] + "\t"); // copy to file
					}
				}
			}
			outputStream.println();
		}
		outputStream.close();
	}

	public void deleteDataFile() {
		f.delete();
	}
}
