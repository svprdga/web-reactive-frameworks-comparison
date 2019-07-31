import { injectable, inject } from "inversify";
import { GalaxyService } from "./abstraction/galaxy.service.int";
import { TYPES_DATA } from "../data/abstraction/types";
import { DatabaseService } from "../data/abstraction/database.service.int";

@injectable()
export class GalaxyServiceImpl implements GalaxyService {

  constructor(
    @inject(TYPES_DATA.DatabaseService) private _database: DatabaseService
  ) { }

  getAllGalaxies(): Promise<any> {
    return new Promise((resolve, reject) => {

      this._database.getModel('Galaxy').findAll()
        .then((result: any) => {
          resolve(result);
        }).catch((error: any) => {
          reject(error);
        });

    });
  }

}