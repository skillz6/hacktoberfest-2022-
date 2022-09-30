//Question No. 03

//Sum up the beauty

//only Solution part

class Solution {
  public:
    long long calcBeauty(int n, vector<int> arr){
        long long int ans=0;
        map<int,vector<int>>m;
        for(int x=0;x<n;x++)m[arr[x]].push_back(x);
        for(auto & x:m){
            for(int y=0;y<x.second.size();y++){
                int l= -1;
                int r = n;
                if(y>0)
                    l=x.second[y-1];
                if(y<x.second.size()-1)
                    r=x.second[y+1];
                ans+=(r-x.second[y])*(x.second[y]-l*1LL);
            }
        }
        return ans;
    }
};