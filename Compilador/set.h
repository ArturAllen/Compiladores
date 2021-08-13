#include <stdio.h>

typedef struct set set;
struct set{
	int vetor[256];
};

set mkset(int v[], int n){
	set s;
	for(int i = 0; i < 256; i++){
		s.vetor[i] = 0;
	}
	for(int i = 0; i < n; i++){
		if(v[i]<256) s.vetor[v[i]]=1;
	}
	return s;
}

set emptySet(){
	set s;
	for(int i = 0; i < 256; i++){
		s.vetor[i]=0;
	}
	return s;
}

set setUnion(set fs, set ss){
	set s;
	for(int i = 0; i < 256; i++)
		s.vetor[i]= fs.vetor[i] | ss.vetor[i];
	return s;
}

set setIntersection(set fs, set ss){
	set s;
	for(int i = 0; i < 256; i++)
		s.vetor[i]= fs.vetor[i] & ss.vetor[i];
	return s;
}

set setDifference(set fs, set ss){
	set s;
	for(int i = 0; i < 256; i++)
		s.vetor[i]= fs.vetor[i] & ~ss.vetor[i];
	return s;
}

set setInclude(set s, int n){
	set sr;
	for(int i = 0; i<256; i++)
		sr.vetor[i]=s.vetor[i];
	if(n<256)
		sr.vetor[n]=1;
	return sr;
}

set setRemove(set s, int n){
	set sr;
	for(int i = 0; i<256; i++)
		sr.vetor[i]=s.vetor[i];
	if(n<256)
		sr.vetor[n]=0;
	return sr;
}

int isInSet(set s, int n){
	if(n>=256) return 0;
	return s.vetor[n];
}

int firstElement(set s){
	int i;
	for(i = 0; i < 256; i++)
		if(s.vetor[i]) return i;
	return i;
}

int nextElement(set s, int n){
	int i;
	for(i = n+1; i < 256; i++)
		if(s.vetor[i]) return i;
	return i;
}

void printset(set s){
	int fflag=1;
	printf("[");
	for(int i = 0; i<256; i++){
		if(s.vetor[i]==1){
			if(fflag){ 
				printf("%d", i);
				fflag=0;
			}
			else printf(", %d", i);
		}
	}
	printf("]\n");
}

void cpyArray(int font[], int trgt[], int n){
	for(int i = 0; i < n; i++)
		trgt[i]=font[i];
}

void cpyString(char font[], char trgt[]){
	int i;
	for(i = 0; font[i] != '\0'; i++){
		trgt[i]=font[i];
	}
	trgt[i]=font[i];
}
