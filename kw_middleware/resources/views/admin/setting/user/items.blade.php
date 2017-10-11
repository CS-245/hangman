@extends('layouts.admin.app')

@section('header')
    <link href="{{ asset('vendor/datatables.net-bs/css/dataTables.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-buttons-bs/css/buttons.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-responsive-bs/css/responsive.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/datatables.net-scroller-bs/css/scroller.bootstrap.min.css') }}" rel="stylesheet">
    <link href="{{ asset('vendor/bootstrap-multiselect/css/bootstrap-multiselect.css') }}" rel="stylesheet">

@endsection  
@section('content')
  <input type="hidden" id="hd_define" data-import-link="{{ url('/api/v1/reports/import') }}" data-export-link="{{ url('/api/v1/reports/export') }}" data-index-link="{{ url('/api/v1/reports/index') }}">
  <body>
<!--   <button id="reset" class="btn btn-success"> -->
<!--   	Reset -->
<!--   </button> -->
<!--     <select id="column-visible" multiple="multiple">                         -->
<!--         <option id="no" value="0">Number</option> -->
<!--         <option id="name" value="1">Name</option> -->
<!--         <option id="email" value="2">Email</option> -->
<!--         <option id="auth" value="3">Authentication</option> -->
<!--         <option id="active" value="4">Activation</option> -->
<!--         <option id="del" value="5">Delete</option> -->
<!--         <option id="create" value="6">Create</option> -->
<!--         <option id="action" value="7">Action</option>   					 -->
<!-- 	</select> -->
    <div class="container">
      <br/>
      <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-6">
          <div class="row"><!--  -->
            <form action="{{url('items/import')}}" method="post" enctype="multipart/form-data">
              <div class="col-md-6">
                {{csrf_field()}}
                <input type="file" name="imported-file"/>
              </div>
              <div class="col-md-6">
                  <button class="btn btn-primary" type="submit">Import</button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-md-2"><!--  -->
          <form action="{{url('items/export')}}" enctype="multipart/form-data">
<!--             <button class="btn btn-success" type="submit">Export</button> -->
          </form>
        </div>
      </div>
      <div class="row">

      </div>
    </div>
  </body>
@endsection

@section('after-script')
    <script src="{{ asset('vendor/datatables.net/js/jquery.dataTables.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net/js/fnFindCellRowIndexes.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-bs/js/dataTables.bootstrap.min.js') }}"></script>
         
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.buttons.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.flash.min.js') }}"></script>
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/jszip.min.js') }}"></script>   
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colReorder.min.js') }}"></script>   
    <script src="{{ asset('vendor/datatables.net-buttons/js/dataTables.colResize.js') }}"></script>   
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.html5.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.print.min.js') }}"></script>
    
    <script src="{{ asset('vendor/datatables.net-buttons/js/buttons.colvis.min.js') }}"></script>
    <script src="{{ asset('vendor/bootstrap-multiselect/js/bootstrap-multiselect.js') }}"></script>

    <script src="{{ asset('vendor/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-keytable/js/dataTables.keyTable.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive/js/dataTables.responsive.min.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-responsive-bs/js/responsive.bootstrap.js') }}"></script>
    <script src="{{ asset('vendor/datatables.net-scroller/js/dataTables.scroller.min.js') }}"></script>
  	<script src="{{ asset('js/csvUpAndDown.js') }}"></script>
@endsection