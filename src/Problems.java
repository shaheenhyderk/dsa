import java.util.*;

public class Problems {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }

    public static int numberOfWaysToMakeChange(int n, int[] coins) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (coin <= amount) {
                    ways[amount] += ways[amount - coin];
                }
            }
        }
        return ways[n];
    }

    public static int minNumberOfCoinsForChange(int n, int[] coins) {
        int[] numOfCoins = new int[n + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare;
        for (int coin : coins) {
            for (int amount = 0; amount < numOfCoins.length; amount++) {
                if (coin <= amount) {
                    if (numOfCoins[amount - coin] == Integer.MAX_VALUE) {
                        toCompare = numOfCoins[amount - coin];
                    } else {
                        toCompare = numOfCoins[amount - coin] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }


    //    Greedy Algorithms---------------------------------------------------------------------------------------------------------------------------------------
    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Collections.reverseOrder());
        blueShirtHeights.sort(Collections.reverseOrder());

        String RED = "RED";
        String BLUE = "BLUE";

        String colorInFirst = redShirtHeights.get(0) < blueShirtHeights.get(0) ? RED : BLUE;

        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            if (colorInFirst.equals(RED)) {
                if (redShirtHeights.get(idx) >= blueShirtHeights.get(idx)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(idx) >= redShirtHeights.get(idx)) {
                    return false;
                }
            }
        }
        return true;
    }


    public ArrayList<ArrayList<Integer>> taskAssignment(ArrayList<Integer> tasks) {
        int k = tasks.size() / 2;
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> taskDurationToIndices = getTaskDurationToIndices(tasks);

        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        for (int idx = 0; idx < k; idx++) {
            int task1Duration = sortedTasks.get(idx);
            ArrayList<Integer> indicesWithTask1Duration = taskDurationToIndices.get(task1Duration);
            int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);

            int task2Duration = sortedTasks.get(tasks.size() - 1 - idx);
            ArrayList<Integer> indicesWithTask2Duration = taskDurationToIndices.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<>();
            pairedTask.add(task1Index);
            pairedTask.add(task2Index);
            pairedTasks.add(pairedTask);
        }
        return pairedTasks;
    }

    public static Map<Integer, ArrayList<Integer>> getTaskDurationToIndices(ArrayList<Integer> tasks) {
        Map<Integer, ArrayList<Integer>> taskToIndices = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            int time = tasks.get(i);
            if (taskToIndices.containsKey(time)) {
                taskToIndices.get(time).add(i);
            } else {
                taskToIndices.put(time, new ArrayList<>(Collections.singletonList(i)));
            }
        }
        return taskToIndices;
    }


    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int noOfCities = distances.length;
        int milesRemaining = 0;

        int indexOfStartingCity = 0;
        int milesRemainingAtStartingCity = 0;

        for (int cityIdx = 1; cityIdx < noOfCities; cityIdx++) {
            int distanceFromPreviousCity = distances[cityIdx-1];
            int fuelFromPreviousCity = fuel[cityIdx-1];
            milesRemaining +=fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesRemaining < milesRemainingAtStartingCity){
                milesRemainingAtStartingCity = milesRemaining;
                indexOfStartingCity = cityIdx;
            }
        }
        return indexOfStartingCity;
    }


    public static void main(String[] args) {
    }
}
