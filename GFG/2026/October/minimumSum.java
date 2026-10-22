class Solution {
    public int minimumSum(String s) {
        // code here
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        for(int i = 0; i<n/2; i++)
        {
            int j = n - 1 - i;
            
            if(arr[i] != '?' && arr[j] != '?')
            {
                if(arr[i] != arr[j])
                {
                    return -1;
                }
            }
            
            else if(arr[i] == '?' && arr[j] != '?')
            {
                arr[i] = arr[j];
            }
            
            else if(arr[i] != '?' && arr[j] == '?')
            {
                arr[j] = arr[j];
            }
            
        }
        
        int half = (n+1)/2;
        
        char firstKnown = 'a';
        
        for(int i = 0; i<half; i++)
        {
            if(arr[i] != '?')
            {
                firstKnown = arr[i];
                break;
            }
        }
        
        for(int i = 0; i<half; i++)
        {
            if(arr[i] == '?')
            {
                arr[i] = firstKnown;
            }
            else
            {
                break;
            }
        }
        
        for(int i = 1; i<half; i++)
        {
            if(arr[i] == '?')
            {
                arr[i] = arr[i-1];
            }
        }
        
        for(int i = 0; i<n/2; i++)
        {
            arr[n-1-i] = arr[i];
        }
        
        int sum = 0;
        
        for(int i = 0; i<n-1; i++)
        {
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        
        return sum;
    }
}
