import * as Sequelize from 'sequelize';

export interface DatabaseService {
  getModel<T>(name: string): Sequelize.Model<T, {}>;
}
