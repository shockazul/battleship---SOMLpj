# ! /bin/bash
git clone https://github.com/SOMLpj/Battleship.git

cd battleship

docker build -t battleship .

docker run -it battleship