import { injectable } from "inversify";
import * as Sequelize from 'sequelize';
import { Galaxy } from "../model/galaxy.model";
import { DatabaseService } from "./abstraction/database.service.int";

@injectable()
export class DatabaseServiceImpl implements DatabaseService {

  protected _database: Sequelize.Sequelize;
  protected _models: { [index: string]: Sequelize.Model<any, any> } = {};

  constructor(database: string, user: string, password: string, options: {}) {
    this._database = new Sequelize(database, user, password, options);

    this._models.Galaxy = this._database.define<Galaxy, {}>('Galaxy', {
      id: {
        primaryKey: true,
        type: Sequelize.INTEGER,
      },
      name: Sequelize.STRING,
      description: Sequelize.STRING
    }, {
        tableName: 'galaxy',
        timestamps: false,
      });
  }

  public getModel<T>(name: string): Sequelize.Model<T, {}> {
    return this._models[name] as Sequelize.Model<T, {}>;
  }
}