FROM java:8
WORKDIR battleship
COPY ./ ./
RUN javac Battleship.java
CMD ["java", "Battleship"]