# ! /bin/bash
sudo apt update
sudo apt upgrade
sudo apt install git

git clone https://github.com/SOMLpj/Battleship.git

cd battleship

sudo apt-get update -y && sudo apt-get install -y linux-image-extra-$(uname -r)
sudo apt-get install docker-engine -y
sudo service docker start
sudo docker run hello-world
docker build -t battleship .

docker run -it battleship