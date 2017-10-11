<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
use App\User;
use Illuminate\Database\Seeder;
use Spatie\Permission\Models\Permission;
use Spatie\Permission\Models\Role;

/**
 * @author Jeff So
 * @file RoleAndPermissionSeeder.php
 * @brief Insert to database for Role & Permission and create user.
 */
class RoleAndPermissionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
       $superAdminRole = Role::create(['name' => 'super-admin']);
       $adminRole = Role::create(['name' => 'admin']);
       $userRole = Role::create(['name' => 'user']);

       $createPermission = Permission::create(['name' => 'create']);
       $readPermission = Permission::create(['name' => 'read']);
       $updatePermission = Permission::create(['name' => 'update']);
       $deletePermission = Permission::create(['name'=> 'delete']);
       $printPermission = Permission::create(['name'=> 'print']);

       $adminRole -> givePermissionTo('create', 'read', 'update', 'delete', 'print');
       $userRole -> givePermissionTo('read', 'print');

        $superUser = User::create([
            'first_name' => 'Lenny',
            'last_name' => 'Yang',
            'email' => 'lenny.yang@kwitech.com',
            'password' => bcrypt('123456'),
            'cell_phone' => '661-714-9425',
            'activate_yn' => 'Y',
        ]);

        $superUser -> assignRole('super-admin');
    }
}
