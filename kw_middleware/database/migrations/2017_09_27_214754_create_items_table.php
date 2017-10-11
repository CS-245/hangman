<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateItemsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
      Schema::create('items', function (Blueprint $table) {
          
          $table->integer('sender');
          $table->integer('reciever');
          $table->integer('po_number');
          $table->integer('release_number');
          $table->date('po_date');
          $table->string('terms_info');
          $table->string('fob_info');
          $table->string('ship_to_name');
          $table->string('ship_to_address1');
          $table->string('ship_to_address2');
          $table->string('ship_to_location');
          $table->string('ship_to_city');
          $table->string('ship_to_state');
          $table->integer('ship_to_postal');
          $table->string('ship_to_country');
          $table->string('ship_to_contact');
          $table->string('bill_to_name');
          $table->string('bill_to_address1');
          $table->string('bill_to_address2');
          $table->string('bill_to_location');
          $table->string('bill_to_city');
          $table->string('bill_to_state');
          $table->integer('bill_to_postal');
          $table->string('bill_to_country');
          $table->string('bill_to_contact');
          $table->string('hdr_user_defined_field1');
          $table->integer('hdr_user_defined_field2');
          $table->integer('hdr_user_defined_field3');
          $table->string('hdr_user_defined_field4');
          $table->string('hdr_user_defined_field5');
          $table->string('hdr_user_defined_field6');
          $table->string('hdr_user_defined_field7');
          $table->integer('hdr_user_defined_field8');
          $table->string('hdr_user_defined_field9');
          $table->date('hdr_user_defined_field10');
          $table->date('hdr_user_defined_field11');
          $table->string('hdr_user_defined_field12');
          $table->string('hdr_user_defined_field13');
          $table->string('hdr_user_defined_field14');
          $table->string('hdr_user_defined_field15');
          $table->string('hdr_user_defined_field16');
          $table->string('hdr_user_defined_field17');
          $table->string('hdr_user_defined_field18');
          $table->string('hdr_user_defined_field19');
          $table->string('hdr_user_defined_field20');
          $table->string('notes');
          $table->integer('line_nmr');
          $table->integer('supplier_item_nbr');
          $table->string('item_description');
          $table->integer('quantity');
          $table->integer('unit_price');
          $table->string('uom_basis_of_uom');
          $table->string('buyer_item_nbr');
          $table->string('manufacturer_item_nbr');
          $table->integer('dtl_user_defined_field1');
          $table->string('dtl_user_defined_field2');
          $table->string('dtl_user_defined_field3');
          $table->string('dtl_user_defined_field4');
          $table->string('dtl_user_defined_field5');
          $table->string('dtl_user_defined_field6');
          $table->integer('dtl_user_defined_field7');
          $table->string('dtl_user_defined_field8');
          $table->string('dtl_user_defined_field9');
          $table->string('dtl_user_defined_field10');
          $table->string('dtl_user_defined_field11');
          $table->string('dtl_user_defined_field12');
          $table->string('dtl_user_defined_field13');
          $table->string('dtl_user_defined_field14');
          $table->string('dtl_user_defined_field15');
          $table->string('dtl_user_defined_field16');
          $table->string('dtl_user_defined_field17');
          $table->string('dtl_user_defined_field18');
          $table->string('dtl_user_defined_field19');
          $table->string('dtl_user_defined_field20');
          $table->string('po_purpose');
          $table->string('sac_info');
          $table->date('delivery_date_requested');
          $table->date('last_delivery_date_requested');
          $table->string('sub_line_item');
          $table->string('item_info');
          
          
          
          
          
          
          
      });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
          Schema::dropIfExists('items');
    }
}
