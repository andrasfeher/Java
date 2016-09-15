import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Homework1 {

	private static Map<String, Integer> getIdCountMap(String fileName) throws IOException {

		Map<String, Integer> map = new HashMap<String, Integer>();

		String line = null;

		FileReader fileReader = new FileReader(fileName);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {

			if (map.containsKey(line)) {
				map.put(line, map.get(line) + 1);
			} else {
				map.put(line, 1);
			}
		}

		bufferedReader.close();

		return map;

	}

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

	public static void main(String[] args) {

		List<String> sourceFileList = new ArrayList<String>(
				Arrays.asList("result.txt", "result.txt", "result.txt", "result.txt"));

		ResultBuffer resultBuffer = new ResultBuffer("result.txt");

		for (String sourceFile : sourceFileList) {

			try {

				long startTime = System.currentTimeMillis();

				// get id - count pairs
				Map<String, Integer> idCountMap = getIdCountMap(sourceFile);

				// sort
				List<Entry<String, Integer>> sortedIdCountList = getSortedIdCountList(idCountMap);

				// add to result buffer
				Result result = new Result();
				result.setFileName(sourceFile);
				result.setExecutionTime(System.currentTimeMillis() - startTime);
				result.setAnalysisResult(sortedIdCountList.toString());

				resultBuffer.add(result);
				
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + sourceFile + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + sourceFile + "'");
			}
		}

		resultBuffer.saveToFile();

		System.out.println("Done. Total execution time: " + resultBuffer.getTotalExecutionTime() + "ms");
	}
}