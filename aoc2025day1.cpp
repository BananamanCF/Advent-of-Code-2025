
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

void solve() {

	ifstream cin("t2.txt");

	ll res = 0;

	// int n, m; cin >> n >> m;
	// vector<vector<ll>> mat(n, vector<ll>(m, 0));
	// for(int i=0;i<n;i++)
	// 	for(int j=0;j<m;j++)
	// 		cin >> mat[i][j];


	string s;
	int cur = 50;
	while(cin >> s){
		char c = s[0];
		int dis = stoi(s.substr(1, s.size()-1));
		//cout << c << " " << dis << endl;
		res += dis/100;
		int rem = dis%100;

		if(c == 'L'){
			if(cur != 0 && cur - rem <= 0)res++;

			cur = ((cur - rem) + 100) % 100;
		}
		else{
			if(cur != 0 && cur + rem >= 100)res++;

			cur = (cur + rem) % 100;
		}

		//cout << cur << " " << res << endl;

	
	}		

    cout << res;
}


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

