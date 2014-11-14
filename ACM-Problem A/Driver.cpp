//
//  Driver.cpp
//  MyProject
//
//  Created by Changsong Li on 11/11/14.
//  Copyright (c) 2014 EpicGames. All rights reserved.
//

#include "iostream"

using namespace std;

void fillArr( long* data, long* height, int num ){
    data[0] = 1;
    height[0] = 1;
    long pow[num];
    pow[0] = 1;
    for (int i = 1; i < num; i++) {
        pow[i] = pow[i-1] * 2;
    }
    
    data[0] = 1;
    height[0] = 1;
    for (int i = 1; i < num; i++) {
        height[i] = height[i-1] + pow[i];
        data[i] = (i + 1) * pow[i] + data[i-1];
    }
}

void solve(){
    long data[20];
    long height[20];
    
    fillArr(data,height,20);
    long output;
    long input;
    int c = 1;
    cin >> input;
    
    while ( input > 0 ) {
        int row = 0;
        while (input >= height[row]) {
            row++;
        }
        output = data[row - 1] + (row + 1) * ( input - height[row -1]);
        cout << "Case " << c << ": " << output << endl;
        c++;
        cin >> input;
    }
}


int main(){
    solve();
}
