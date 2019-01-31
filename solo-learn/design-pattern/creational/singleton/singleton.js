class Logger {
  static getInstance() {
    if (this.logger === undefined) {
      this.logger = new Logger();
    }
    return this.logger;
  }
}

logger1 = Logger.getInstance();
logger2 = Logger.getInstance();
console.log(logger1 === logger2);
