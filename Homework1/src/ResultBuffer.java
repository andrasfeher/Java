import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultBuffer {

	private String resultFileName;
	private List<Result> resultList;
	private long totalExecutionTime = 0; 

	public ResultBuffer(String resultFileName) {
		this.resultFileName = resultFileName;
		this.resultList = new ArrayList<Result>();
	}

	public void add(Result result) {
		resultList.add(result);
		setTotalExecutionTime(getTotalExecutionTime() + result.getExecutionTime());
	}

	public void saveToFile(){

		FileWriter fileWriter;

		try {

			fileWriter = new FileWriter(resultFileName);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (Result result : resultList){

				bufferedWriter.write(
					"File name: " + result.getFileName() 
					+ " ; " + "Time: " + result.getExecutionTime() + "ms"
					+ " ; " + "Analysis result: " + result.getAnalysisResult()
				);
				bufferedWriter.newLine();
				
			}

			bufferedWriter.close();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public long getTotalExecutionTime() {
		return totalExecutionTime;
	}

	public void setTotalExecutionTime(long totalExecutionTime) {
		this.totalExecutionTime = totalExecutionTime;
	}

}
