import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;

import org.apache.commons.lang3.StringUtils;

public class Homework1 {

	private static Configuration conf;
	private static List<String> sourceFileList;
	private static FileSystem fs;

	private static List<Entry<String, Integer>> getSortedIdCountList(Map<String, Integer> idCountMap) {

		ArrayList<Entry<String, Integer>> idCountList = new ArrayList<Entry<String, Integer>>(idCountMap.entrySet());

		Collections.sort(idCountList, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> idCountList0, Entry<String, Integer> idCountList1) {

				return -(idCountList0.getValue() - idCountList1.getValue());
			}

		});

		return idCountList;

	}

	private static Map<String, Integer> getIdCountMap(){

		Map<String, Integer> idCountMap = new HashMap<String, Integer>();

		for (String sourceFile : sourceFileList) {
		
			try {
				Path inFile = new Path(sourceFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(inFile)));

				String line = null;

				while ((line = br .readLine()) != null) {

					String[] values = line.split("\\t", -1);

					String iPinyouID = values[2];

					if (idCountMap.containsKey(iPinyouID)) {
						idCountMap.put(iPinyouID, idCountMap.get(iPinyouID) + 1);
					} else {
						idCountMap.put(iPinyouID, 1);
					}

				}

				br .close();

				
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + sourceFile + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + sourceFile + "'");
			}
		}

		return idCountMap;
	}


	private static void saveToResultFile(List<Entry<String, Integer>> sortedIdCountList){
		
		try {
			Path resultFile = new Path("home/andras_feher/homework_1/result.txt");

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fs.create(resultFile, true)));
			for (Entry<String, Integer> sortedIdCount : sortedIdCountList){

				bufferedWriter.write(sortedIdCount.getKey() + ":" + sortedIdCount.getValue());
				
				bufferedWriter.newLine();
			}

				
			bufferedWriter.close();	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		sourceFileList = new ArrayList<String>(
			Arrays.asList(
				"home/andras_feher/homework_1/bid.20130606.txt",
				"home/andras_feher/homework_1/bid.20130607.txt",
				"home/andras_feher/homework_1/bid.20130608.txt",
				"home/andras_feher/homework_1/bid.20130609.txt",
				"home/andras_feher/homework_1/bid.20130610.txt",
				"home/andras_feher/homework_1/bid.20130611.txt",
				"home/andras_feher/homework_1/bid.20130612.txt"
		));

		conf = new Configuration();
		fs = FileSystem.get(conf);
		

		long startTime = System.currentTimeMillis();

		// get id - count pairs
		Map<String, Integer> idCountMap = getIdCountMap();

		// sort id - count map
		List<Entry<String, Integer>> sortedIdCountList = getSortedIdCountList(idCountMap);

		// save result to file
		saveToResultFile(sortedIdCountList);

		System.out.println("Done. Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
	}
}