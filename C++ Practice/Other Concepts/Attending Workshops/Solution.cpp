#include<bits/stdc++.h>

using namespace std;
struct Workshop {
    int start_time, duration, end_time;
    bool operator<(const Workshop& another) const {
        return end_time < another.end_time;
    }
};

struct Available_Workshops {
    int N;
    vector<Workshop> arr;
};

Available_Workshops* initialize(int start_time[], int duration[], int N) {
    Available_Workshops* workshop = new Available_Workshops;
    workshop->N = N;
    for (int i = 0; i < N; i++) {
        Workshop temp;
        temp.start_time = start_time[i];
        temp.duration = duration[i];
        temp.end_time = start_time[i] + duration[i];
        workshop->arr.push_back(temp);
    }
    return workshop;
}

int CalculateMaxWorkshops(Available_Workshops* ptr) {
    int res = 0;
    sort(ptr->arr.begin(), ptr->arr.end());
    int end_time = -1;
    for (int i = 0; i < ptr->N; i++) {
        if (ptr->arr[i].start_time >= end_time) {
            res++;
            end_time = ptr->arr[i].end_time;
        }
    }
    return res;
}
//Define the structs Workshops and Available_Workshops.
//Implement the functions initialize and CalculateMaxWorkshops

int main(int argc, char *argv[]) {
    int n; // number of workshops
    cin >> n;
    // create arrays of unknown size n
    int* start_time = new int[n];
    int* duration = new int[n];

    for(int i=0; i < n; i++){
        cin >> start_time[i];
    }
    for(int i = 0; i < n; i++){
        cin >> duration[i];
    }

    Available_Workshops * ptr;
    ptr = initialize(start_time,duration, n);
    cout << CalculateMaxWorkshops(ptr) << endl;
    return 0;
}
