package framework.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
    private static int count=0;
    private static  final int limit =3;


    @Override
    public boolean retry(ITestResult iTestResult) {

        if(count<limit){
            count++;
            return true;
        }else{
            return false;
        }

    }
}
