import 'reflect-metadata';

import * as cors from 'cors';
import { Application } from 'express';
import { Container } from 'inversify';
import { InversifyExpressServer } from 'inversify-express-utils';
import * as bodyParser from 'body-parser';

import { TYPES_SERVICE } from './service/abstraction/types';
import { GalaxyService } from './service/abstraction/galaxy.service.int';
import { GalaxyServiceImpl } from './service/galaxy.service';

import { TYPES_DATA } from './data/abstraction/types';
import { DatabaseService } from './data/abstraction/database.service.int';
import { DatabaseServiceImpl } from './data/database.service';

import './controller';

const container = new Container({
  defaultScope: 'Singleton',
});

container.bind<DatabaseService>(TYPES_DATA.DatabaseService).toConstantValue(
  new DatabaseServiceImpl(
    'reactivecomp_db',
    'reactivecomp_user',
    'reactivecomp_pwd',
    {
      dialect: 'postgres',
      dialectOptions: {
        encrypt: true,
      },
      host: 'localhost',
      logging: (message: string) => {
        console.log(message);
      },
      pool: {
        idle: 10000,
        max: 5,
        min: 0,
      },
      port: 5432,
    }
  )
);

container.bind<GalaxyService>(TYPES_SERVICE.GalaxyService).to(GalaxyServiceImpl);

const server = new InversifyExpressServer(container);

server.setConfig((app: Application) => {
  app.use(cors());
  app.use(bodyParser.json());  
});

export const serverInstance = server.build();
serverInstance.listen(8000);