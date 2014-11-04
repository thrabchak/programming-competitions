public class CandyMaking {
  
  public double findSuitableDensity(int[] containerVolume, int[] desiredWeight){
    double[] desiredDensities = createDesiredDensitiesArray(containerVolume, desiredWeight);
    double density = computeAvg(desiredDensities);
    double[] actualWeights = getActualWeights(containerVolume, density);
    double[] differences = computeDifferences(actualWeights, desiredWeight);
    double sumOfDifferences = sumDifferences(differences);
    return sumOfDifferences;
  }

  public double[] createDesiredDensitiesArray(int[] containerVolume, int[] desiredWeight){
    double[] desiredDensities = new double[containerVolume.length];
    for(int i = 0; i < containerVolume.length; i++){
      desiredDensities[i] = (double)desiredWeight[i] / (double)containerVolume[i];
    }
    return desiredDensities;
  }

  public double computeAvg(double[] arr){
    double sum = 0;
    for(int i = 0; i < arr.length; i++)
      sum += arr[i];
    return sum/(double)arr.length;
  }

  public double[] getActualWeights(int[] containerVolume, double density){
    double[] actualWeights = new double[containerVolume.length];
    for(int i = 0; i < actualWeights.length; i++)
      actualWeights[i] = (double)containerVolume[i] * density;
    return actualWeights;
  }

  public double[] computeDifferences(double[] actualWeights, int[] desiredWeight){
    double[] differences = new double[actualWeights.length];
    for(int i = 0; i < differences.length; i++)
      differences[i] = Math.abs((double)desiredWeight[i] - actualWeights[i]);
    return differences;
  }

  public double sumDifferences(double[] differences){
    double sum = 0; 
    for(int i = 0; i < differences.length; i++)
      sum += differences[i];
    return sum;
  }

}