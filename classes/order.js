module.exports = class Order {
  constructor(livreur , xCord, yCord, timeLimit) {
    this.livreur = livreur;
    this.x = xCord;
    this.y = yCord;
    this.timeLimit = timeLimit
  }
};
