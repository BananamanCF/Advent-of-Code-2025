
#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>
#include <algorithm>
#include <bits/stdc++.h>

using namespace std;
using ll = long long;
const int mod = (int)(1e9+7);
const vector<vector<int>> dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

bool valid(int x, int y, int n, int m){
    return x>=0 && x<n && y>=0 && y<m;
}

vector<vector<ll>> dp;

ll f(int i, string& s, int t){
	if(i>=s.size()){
		return t==12 ? 0 : -(ll)1e18;
	}
	if(t >= 13)
		return -(ll)1e18;
	if(dp[i][t] != -1)
		return dp[i][t];

	ll cur = s[i]-'0';

	ll take = cur * pow(10, 12-t-1) + f(i+1, s, t+1);
	ll notTake = f(i+1, s, t);

	return dp[i][t] = max(take, notTake);

}

void solve() {

	ifstream cin("t1.txt");
	string gar;

	ll sum = 0;
	string line;
	while(cin >> line){
		dp.assign(100, vector<ll>(15, -1));
		sum += f(0, line, 0);
	}
	cout << sum;

}

	// int n, m; cin >> n >> m;
	// vector<vector<ll>> mat(n, vector<ll>(m, 0));
	// for(int i=0;i<n;i++)
	// 	for(int j=0;j<m;j++)
	// 		cin >> mat[i][j];


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int tc = 1;
    //cin >> tc;
    while (tc-- != 0)
        solve();

    return 0;
}

