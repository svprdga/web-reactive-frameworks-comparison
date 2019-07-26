import 'package:aqueduct_module/aqueduct_module.dart';

class Galaxy extends ManagedObject<_Galaxy> implements _Galaxy {}

@Table(name: "galaxy")
class _Galaxy {
  @primaryKey
  int id;

  @Column()
  String name;

  @Column()
  String description;
}

