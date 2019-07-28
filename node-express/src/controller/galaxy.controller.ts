import { controller, httpGet } from "inversify-express-utils";
import { inject } from "inversify";
import { TYPES_SERVICE } from "../service/abstraction/types";
import { GalaxyService } from "../service/abstraction/galaxy.service.int";

@controller('/galaxies')
export class GalaxyController {

  constructor(
    @inject(TYPES_SERVICE.GalaxyService) private _service: GalaxyService
  ) { }

  @httpGet('')
  public getGalaxies(request: Request, response: Response): Promise<void> {
    return new Promise<void>((resolve, reject) => {

      this._service.getAllGalaxies()
        .then((result: any) => {
          response.status(200).jsonp(result)
          resolve();
        }).catch((error) => {
          response.status(500).jsonp(error);
          reject();
        })

    });
  }

}