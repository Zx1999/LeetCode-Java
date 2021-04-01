//getNext求解长度为length的字符串s的next数组
void getNext(char s[], int length) {
    int j = -1;
    next[0] = -1;
    for(int i = 1; i < length; i++) {
        while(j != -1 && s[i] != s[j + 1]) {
            j = next[j];
        }
        if(s[i] == s[j + 1]) {
            j++;
        }
        next[i] = j;
    }
}

//KMP算法 判断pattern是否为text的子串
bool KMP(char text[], char pattern[]) {
    int n = strlen(text), m = strlen(pattern);
    int j = -1;
    getNext(pattern, m);
    for(int i = 0; i < n; i++) {
        while(j != -1 && text[i] != pattern[j + 1]) {
            j = next[j];
        }
        if(text[i] == pattern[j + 1]) {
            j++;
        }
        if(j == m - 1) {
            return true;
        }
    }   
    return false;
}

//KMP算法 统计pattern在text中的出现次数
int KMP(char text[], char pattern[]) {
    int n = strlen(text), m = strlen(pattern);
    int ans = 0, j = -1;
    getNext(pattern, m);
    for(int i = 0; i < n; i++) {
        while(j != -1 && text[i] != pattern[j + 1]) {
            j = next[j];
        }
        if(text[i] == pattern[j + 1]) {
            j++;
        }
        if(j == m - 1) {
            ans++;
            j = next[j];
        }
    }   
    return ans;
}

//getNextval求解长度为length的字符串s的nextval数组
//nextval数组可以理解为当模式串pattern的i+1位发生失配时，i位应该退回的最佳位置（pattern[i+1] != pattern[next[i]+1]）
void getNextval(char s[], int length) {
    int j = -1;
    nextval[0] = -1;
    for(int i = 1; i < length; i++) {
        while(j != -1 && s[i] != s[j + 1]) {
            j = next[j];
        }
        if(s[i] == s[j + 1]) {
            j++;
        }
        //与getNext函数相比，以下部分不同
        if(j == -1 || s[i + 1] != s[j + 1]) {
            nextval[i] = j;
        } else {
            nextval[i] = nextval[j];
        }
    }
}