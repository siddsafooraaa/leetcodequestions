class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
    int n = students.length;
        int i = 0;
        int j = 0; 
        int remaining = n;
        int unable = 0;
        while (remaining > 0 && unable < remaining) {
            if (students[j] == sandwiches[i]) {
                i++;
                j++;
                remaining--;
                unable = 0;
                if (j == n) {
                    j = 0;
                }
            } else {
                int temp = students[j];
                for (int k = j; k < n - 1; k++) {
                    students[k] = students[k + 1];
                }
                students[n - 1] = temp;
                unable++;
            }
        }
        return remaining;
    }
}    