# word-search-kata

A Java program built to find words in a word search puzzle.

This program was built in Eclipse but should work in any Java supported IDE.

Running the jUnit test file will pass all pre-determined tests. Switching out the word search text will work if the text is formatted the same way. 

Users have the ability to search for a particular word accross any of the axises, diagonally, and backwards. They can also find all matches to the word list in one call.

To use the class, initialize a word search object:
```WordSearch wordSearch = new WordSearch();```

To populate the word search, use text formatted like the following (first line of text determines the words to search for):
```
BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA
U,M,K,H,U,L,K,I,N,V,J,O,C,W,E
L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G
H,S,U,P,J,P,R,J,D,H,S,B,X,T,G
B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E
A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D
S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F
B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z
O,K,R,I,K,A,M,M,R,M,F,B,A,P,P
N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S
E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K
S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D
T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K
O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H
W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S
K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B
```

That block of text can be passed to the word search like so:
```
wordSearch.populateSearch("txtToFillWordSearch");
```

To find all the matches in a word search, use the method findAllMatches() which will return a string:
```
wordSearch.findAllMatches();
```

Returned string with matches will look like this:
```
UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)
SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)
SULU: (3,3),(2,2),(1,1),(0,0)
SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)
BONES: (0,6),(0,7),(0,8),(0,9),(0,10)
KIRK: (4,7),(3,7),(2,7),(1,7)
KHAN: (5,9),(5,8),(5,7),(5,6)
```
```
<div id="root"></div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.4.2/react-dom.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.21.1/babel.min.js"></script>
<script type="text/babel">
class Greeting extends React.Component {
    render() {
        return (<p>Hello world</p>);
    }
}
ReactDOM.render(
    <Greeting />,
    document.getElementById('root')
);
</script>
```
