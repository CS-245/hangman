@extends('layouts.admin')

@section('header')
    <link href="{{asset('resources/admin/plugin/bootstrap-multiselect/css/bootstrap-multiselect.css')}}" rel="stylesheet">
@endsection

@section('content')
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Permission Edit</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>Role Management</a>
                </li>
                <li class="active">
                    <strong>Permission Edit</strong>
                </li>
            </ol>
        </div>
    </div>

    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>
                        </h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form method="POST" class="form-horizontal" action="{{ url('/admin/permission/edit-processing') }}">
                            {{ csrf_field() }}
                            <input type="hidden" name="permission_id" value="{{ $permission->id }}">
                            <div class="form-group{{ $errors->has('name') ? ' has-error' : '' }}"><label class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" value="{{ empty(old('name')) ? $permission->name : old('name') }}" required>
                                    @if ($errors->has('name'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('name') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">Save & Close</button>
                                <a href="javascript:window.history.back();" class="btn btn-danger">Cancel</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection

@section('after-script')
    <script src="{{asset('resources/admin/plugin/bootstrap-multiselect/js/bootstrap-multiselect.js')}}"></script>
    <script>
        $(document).ready(function () {
//            $('#sel-auth').multiselect({
//                enableFiltering: true,
//                includeSelectAllOption: true
//            });
        });
    </script>
@endsection
