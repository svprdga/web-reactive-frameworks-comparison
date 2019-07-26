import 'dart:async';

import 'package:aqueduct/aqueduct.dart';
import 'package:aqueduct_module/model/models.dart';

class GalaxyController extends ResourceController {
  GalaxyController(this.context);

  final ManagedContext context;

  @Operation.get()
  Future<Response> getGalaxies() async {
    final galaxyQuery = Query<Galaxy>(context);
    final galaxies = await galaxyQuery.fetch();
    return Response.ok(galaxies);
  }

}