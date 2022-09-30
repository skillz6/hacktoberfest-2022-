//Question No. 02

//Water Problem

//only Solution part

class Solution{
	public:
	int minCapacity(int n,int a[])
	{
		//code here
		sort(a,a+n);
        int ans= a[0];
        for(int i=1; i<n; i++){
            ans= max(ans,a[i]-i);
        }
        return ans;
	}
};