# ! /bin/bash
sudo apt update
sudo apt upgrade
sudo apt install git

if [ -d ./battleship ]
then
    echo "REPO has already been cloned..."
else
    git clone https://github.com/SOMLpj/Battleship.git
fi

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
