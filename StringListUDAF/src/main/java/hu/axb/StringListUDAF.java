package hu.axb;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.Mode;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

public static class StringListUDAF extends GenericUDAFEvaluator {
    @Override
    public ObjectInspector init(Mode m, ObjectInspector[] parameters) throws HiveException {} 
 
    @Override
    public Object terminatePartial(AggregationBuffer agg) throws HiveException {} 
 
    @Override
    public Object terminate(AggregationBuffer agg) throws HiveException {} 
 
    @Override
    public void merge(AggregationBuffer agg, Object partial) throws HiveException {} 
 
    @Override
    public void iterate(AggregationBuffer agg, Object[] parameters) throws HiveException {} 

    @Override
    public AggregationBuffer getNewAggregationBuffer() throws HiveException {} 
 
    @Override
    public void reset(AggregationBuffer agg) throws HiveException {}   
  } 