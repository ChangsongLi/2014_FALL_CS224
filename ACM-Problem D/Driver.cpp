//
//  Driver.cpp
//  MyProject
//
//  Created by Changsong Li on 11/11/14.
//  Copyright (c) 2014 EpicGames. All rights reserved.
//

#include "iostream"

using namespace std;

void solve(){
    int jobs, time;
    int ca = 1;
    cin >> jobs >> time;
    while( jobs != 0 && time != 0 ){
        int count = 0;
        int slot;
        while (time > 0 && count < jobs) {
            cin >> slot;
            if(time >= slot){
                time = time - slot;
                count++;
            }
            else{
                time = time - slot;
            }
        }
        cout << "Case " << ca << ": " << count <<"\n";
        count++;
        ca++;
        while(count < jobs){
            cin >> slot;
            count++;
        }
        cin >> jobs >> time;
    }
}

int main(){
    solve();
}
