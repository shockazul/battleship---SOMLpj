# ! /bin/bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)" brew doctor

brew install git

git clone https://github.com/SOMLpj/Battleship.git

cd battleship

brew cask install docker

open -a Docker
echo "Please wait while we get everything ready!"
sleep 15s
echo "Almost done!"
sleep 15s
echo "..."
sleep 5s
docker build -t battleship .
echo "We're ready for you now!"
sleep 1s
clear
docker run -it battleship