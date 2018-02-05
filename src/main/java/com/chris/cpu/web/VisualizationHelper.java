package com.chris.cpu.web;

import com.chris.cpu.util.FileUtil;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Make a plot like this: http://bl.ocks.org/d3noob/8603837
 * I need to convert those unsorted score into one sorted csv
 *
 */
public class VisualizationHelper {

    private void storeFinalCSV(String storePath, List<String> finalCSV) {
        try{
            FileWriter fileStream = new FileWriter(storePath);
            BufferedWriter out = new BufferedWriter(fileStream);
            for(int i = 0; i < finalCSV.size(); i++){
                out.write(finalCSV.get(i) + "," + finalCSV.get(i+1)
                        + "," + finalCSV.get(i+2) + "," + finalCSV.get(i+3) + "," + finalCSV.get(i+4) + "\n");
                i = i + 4;
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<String> generateCSVForVsualization(String pcSinglePath, String pcMultiPath,
                                                                     String mobileSinglePath, String mobileMultiPath){
        HashMap<String, String> pcSingleMap = FileUtil.getHashMapFromFile(pcSinglePath);
        HashMap<String, String> pcMultiMap = FileUtil.getHashMapFromFile(pcMultiPath);
        HashMap<String, String> mobileSingleMap = FileUtil.getHashMapFromFile(mobileSinglePath);
        HashMap<String, String> mobileMultiMap = FileUtil.getHashMapFromFile(mobileMultiPath);
        return generateFinalCSV(pcSingleMap, pcMultiMap, mobileSingleMap, mobileMultiMap);
    }

    private List<String> generateFinalCSV(HashMap<String, String> pcSingleMap, HashMap<String, String> pcMultiMap,
                                             HashMap<String, String> mobileSingleMap, HashMap<String, String> mobileMultiMap){

        List<String> finalCSV = new ArrayList<String>();
        addHeadrer(finalCSV); //first line
        addContent(finalCSV, pcSingleMap, pcMultiMap, mobileSingleMap, mobileMultiMap);
        return finalCSV;
    }

    private void addHeadrer(List<String> finalCSV){
        finalCSV.add("semester");
        finalCSV.add("Desktop Single-Core");
        finalCSV.add("Desktop Multi-Core");
        finalCSV.add("Mobile Single-Core");
        finalCSV.add("Mobile Multi-Core");
    }

    private void addContent(List<String> finalCSV, HashMap<String, String> pcSingleMap, HashMap<String, String> pcMultiMap,
                            HashMap<String, String> mobileSingleMap, HashMap<String, String> mobileMultiMap) {
        for (int i = 2007; i <= 2017; i++) {
            String firstSemester = "S1 " + i;
            addOneSemester(firstSemester, finalCSV, pcSingleMap, pcMultiMap, mobileSingleMap, mobileMultiMap);

            String secondSemester = "S2 " + i;
            addOneSemester(secondSemester, finalCSV, pcSingleMap, pcMultiMap, mobileSingleMap, mobileMultiMap);
        }
    }


    private void addOneSemester(String semester, List<String> finalCSV, HashMap<String, String> pcSingleMap, HashMap<String, String> pcMultiMap,
                                HashMap<String, String> mobileSingleMap, HashMap<String, String> mobileMultiMap){
        if(semester.substring(0, 2).equals("S1")) {
            finalCSV.add("1 " + semester.substring(3, 7));
        }else{
            finalCSV.add("7 " + semester.substring(3, 7));
        }
        finalCSV.add(pcSingleMap.get(semester));
        finalCSV.add(pcMultiMap.get(semester));
        if (Integer.valueOf(semester.substring(3, 7)) <= 2011) {
            finalCSV.add("");  //Not sure use 0 or empty, need experiment
            finalCSV.add("");
        } else {
            finalCSV.add(mobileSingleMap.get(semester));
            finalCSV.add(mobileMultiMap.get(semester));
        }
    }

}
