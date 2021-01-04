# ! /bin/bash
sudo apt update
sudo apt upgrade
sudo apt install git

git clone https://github.com/SOMLpj/Battleship.git

cd battleship

sudo apt-get update -y && sudo apt-get install -y linux-image-extra-$(uname -r)
sudo apt-get install docker-engine -y
sudo groupadd docker
sudo usermod -aG docker $(whoami)
sudo service docker start
sudo docker run hello-world

docker build -t battleship .
clear
echo "We're ready for you now!"
sleep 1s
clear
docker run -it battleship
