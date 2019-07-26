import 'aqueduct_module.dart';
import 'controller/galaxy_controller.dart';

class AqueductModuleChannel extends ApplicationChannel {

  ManagedContext context;

  @override
  Future prepare() async {
    logger.onRecord.listen((rec) => print("$rec ${rec.error ?? ""} ${rec.stackTrace ?? ""}"));

    final config = GalaxyConfig(options.configurationFilePath);
    final dataModel = ManagedDataModel.fromCurrentMirrorSystem();
    final persistentStore = PostgreSQLPersistentStore.fromConnectionInfo(
        config.database.username,
        config.database.password,
        config.database.host,
        config.database.port,
        config.database.databaseName);

    context = ManagedContext(dataModel, persistentStore);
  }


  @override
  Controller get entryPoint {
    final router = Router();

    router
      .route("/galaxies")
      .link(() => GalaxyController(context));
    return router;
  }
}

class GalaxyConfig extends Configuration {
  GalaxyConfig(String path): super.fromFile(File(path));

  DatabaseConfiguration database;
}