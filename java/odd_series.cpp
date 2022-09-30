//Question No. 01

//Odd Series

//only Solution part

const int mod= 1e9+7;
class Solution{
    public:
    int findNth(int N){
         
        int prev2= 0, prev= 1;
        int curr;
        if(N == 0)return 0;
        for(int i=2; i<=N; i++){
            
            if(i%5 == 0){
                curr = 11%mod;
                
            }
            else{
                curr= (prev2 + prev)%mod;
            }
            prev2 = prev;
            prev = curr;
        }
        return prev%mod;
    }
};